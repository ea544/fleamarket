package org.fleamarket.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import org.fleamarket.domain.Product;
import org.fleamarket.exception.FleaMarketException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

public class ProductService {
	
	private final String uploadsDir;
	
	private SessionFactory sessionFactory;

	public ProductService(SessionFactory sessionFactory, String uploadsDir) {
		this.sessionFactory = sessionFactory;
		this.uploadsDir = uploadsDir;
	}

	@Transactional
	public Integer createProduct(Product product) {
		Integer id = (Integer)sessionFactory.getCurrentSession().save(product);
		return id;
	}
	
	@SuppressWarnings("rawtypes")
	@Transactional
	public Product getProduct(Integer id) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Product p WHERE p.id = :id");
		query.setParameter("id", id);
		Product product = (Product)query.getSingleResult();
		product.getPhotos();
		return product;
	}
	
	@Transactional
	public void updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return;
	}
	
	/**
	 * save the uploaded file to the uploads dir
	 * add a photo to product object product.addPhoto()
	 * 
	 * @param product
	 * @param file
	 * @throws FleaMarketException
	 */
	@Transactional
	public void addPhoto(Integer id, MultipartFile file) throws FleaMarketException {
		Product product = getProduct(id);
		String filename = "";
		try {
			System.out.println("Uploading "+file.getOriginalFilename());
			filename = uploadPhoto(file);
		}
		catch(FleaMarketException e) {
			throw new FleaMarketException(e.getMessage());
		}
		catch(IOException e) {
			throw new FleaMarketException("There was a problem uploading the photo right now,"
					+ "try again later");
		}
		
		product.addPhoto(filename);
		sessionFactory.getCurrentSession().update(product);
	}
	
	public String createNewFileNameString(MultipartFile file) throws FleaMarketException{
		String filename = file.getOriginalFilename();
		int dot = filename.lastIndexOf(".");
		if( dot == -1)
			throw new FleaMarketException("Invalid file extension");
		String extension = filename.substring(dot);
		String str = UUID.randomUUID().toString().replace('-', '_');
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		long seconds = timestamp.getTime(); //seconds since epoch
		String fileName =  String.format("%s_%d%s", str, seconds, extension);
		System.out.println("New file name is: "+fileName);
		return fileName;
	}
	
	/**
	 * Uploads a submitted photo file into a uploads folder
	 * @param file
	 * @throws FleaMarketException
	 * @throws IOException
	 */
	public String uploadPhoto(MultipartFile file) throws FleaMarketException, IOException {
		StringBuffer filename = new StringBuffer("");
		try {
			filename = filename.append(createNewFileNameString(file));
		}
		catch(FleaMarketException e){
			throw new FleaMarketException(e.getMessage());
		}
		//if (!file.getOriginalFilename().isEmpty()) {
		if (!file.isEmpty()) {
			//Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			BufferedOutputStream outputStream = new BufferedOutputStream(
					new FileOutputStream(
							new File(uploadsDir, filename.toString())));
			outputStream.write(file.getBytes());
	        outputStream.flush();
	        outputStream.close();
		}
		else {
			throw new FleaMarketException("Make sure the file name is valid.");
		}
		return filename.toString();
	}
}
