package com.sadvit.lab6.context;

import java.util.Properties;

import com.sadvit.lab6.service.AbstractService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.sadvit.lab6.dao.CustomerDAO;
import com.sadvit.lab6.dao.ProductDAO;
import com.sadvit.lab6.dao.SaleDAO;
import com.sadvit.lab6.dao.impl.CustomerDAOImpl;
import com.sadvit.lab6.dao.impl.ProductDAOImpl;
import com.sadvit.lab6.dao.impl.SaleDAOImpl;
import com.sadvit.lab6.domain.Customer;
import com.sadvit.lab6.domain.Product;
import com.sadvit.lab6.domain.Sale;
import com.sadvit.lab6.service.CustomerService;
import com.sadvit.lab6.service.ProductService;
import com.sadvit.lab6.service.SaleService;
import com.sadvit.lab6.ui.mvp.EditorBuilder;
import com.sadvit.lab6.ui.mvp.PresenterBuilder;
import com.sadvit.lab6.ui.mvp.baseeditor.BaseModel;
import com.sadvit.lab6.ui.mvp.baseeditor.BasePresenter;
import com.sadvit.lab6.ui.mvp.contenteditor.ContentEditorModel;
import com.sadvit.lab6.ui.mvp.contenteditor.ContentEditorPresenter;
import com.sadvit.lab6.ui.mvp.contentviewer.ContentViewerModel;
import com.sadvit.lab6.ui.mvp.contentviewer.ContentViewerPresenter;
import com.sadvit.lab6.ui.viewer.CustomerModel;
import com.sadvit.lab6.ui.viewer.CustomerPresenter;
import com.sadvit.lab6.ui.viewer.ProductModel;
import com.sadvit.lab6.ui.viewer.ProductPresenter;
import com.sadvit.lab6.ui.viewer.SaleModel;
import com.sadvit.lab6.ui.viewer.SalePresenter;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.sadvit.lab6"})
public class ConfigurationContext {
	
	//------ CONTROLLERS -------
	
	@Bean
	@Autowired
	public SalePresenter salePresenter(SaleModel saleModel) {
		SalePresenter salePresenter = EditorBuilder.build("SaleViewer.fxml");
		salePresenter.setModel(saleModel);
		return salePresenter;
	}
	
	@Bean
	public SaleModel saleModel() {
		return new SaleModel();
	}
	
	@Bean
	@Autowired
	public ProductPresenter productPresenter(ProductModel productModel) {
		ProductPresenter productPresenter = EditorBuilder.build("ProductViewer.fxml");
		productPresenter.setModel(productModel);
		return productPresenter;
	}
	
	@Bean
	public ProductModel productModel() {
		return new ProductModel();
	}
	
	@Bean
	@Autowired
	public CustomerPresenter customerPresenter(CustomerModel customerModel) {
		CustomerPresenter customerPresenter = EditorBuilder.build("CustomerViewer.fxml");
		customerPresenter.setModel(customerModel);
		return customerPresenter;
	}
	
	@Bean
	public CustomerModel customerModel() {
		return new CustomerModel();
	}
	
	//------ CONTROLLERS -------
	
	//------ MVP ---------------
	
	@Bean
	@Autowired
	public ContentViewerPresenter contentViewerPresenter(ContentViewerModel contentViewerModel) {
		ContentViewerPresenter contentViewerPresenter = PresenterBuilder.build("ContentViewerView.fxml");
		contentViewerPresenter.setModel(contentViewerModel);
		return contentViewerPresenter;
	}
	
	@Bean
	@Autowired
	public ContentEditorPresenter contentEditorPresenter(ContentEditorModel contentEditorModel) {
		ContentEditorPresenter contentEditorPresenter = PresenterBuilder.build("ContentEditorView.fxml");
		contentEditorPresenter.setModel(contentEditorModel);
		return contentEditorPresenter;
	}
	
	@Bean
	@Autowired
	public BasePresenter basePresenter(BaseModel baseModel) {
		BasePresenter basePresenter = PresenterBuilder.build("BaseView.fxml");
		basePresenter.setModel(baseModel);
		return basePresenter;
	}
	
	@Bean
	public ContentViewerModel contentViewerModel() {
		return new ContentViewerModel();
	}
	
	@Bean
	public ContentEditorModel contentEditorModel() {
		return new ContentEditorModel();
	}
	
	@Bean
	public BaseModel baseModel() {
		return new BaseModel();
	}
	
	//------ MVP ---------------
	
	//------ SERVICE -----------
	
	@Bean
	@Autowired
	public CustomerService customerService(CustomerDAO customerDAO) {
		return new CustomerService(customerDAO);
	}
	
	@Bean
	@Autowired
	public ProductService productService(ProductDAO productDAO) {
		return new ProductService(productDAO);
	}
	
	@Bean
	@Autowired
	public SaleService saleService(SaleDAO saleDAO) {
		return new SaleService(saleDAO);
	}
	
	//------ SERVICE -----------
	
	//------ DAO ---------------
	
	@Bean
	public ProductDAO productDAO() {
		return new ProductDAOImpl();
	}
	
	@Bean
	public SaleDAO saleDAO() {
		return new SaleDAOImpl();
	}
	
	@Bean
	public CustomerDAO customerDAO() {
		return new CustomerDAOImpl();
	}
	
	//------ DAO ---------------
	
	//------ CONFIGS -----------
	
	@Bean
	@Autowired
	public HibernateTemplate hibernateTemplate(SessionFactory sessionFactory) {
		HibernateTemplate template = new HibernateTemplate();
		template.setSessionFactory(sessionFactory);
		return template;
	}
	
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory (DriverManagerDataSource dataSource) {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setAnnotatedClasses(Product.class, Sale.class, Customer.class);
		sessionFactory.setHibernateProperties(hibernateProperties);
		return sessionFactory;
	}
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("jstels.jdbc.csv.CsvDriver2");
		dataSource.setUrl("jdbc:jstels:csv:storage");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setConnectionProperties(csvProperties);
		return dataSource;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(DriverManagerDataSource dataSource, SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setDataSource(dataSource);
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	
	@SuppressWarnings("serial")
	private Properties hibernateProperties = new Properties() {{
		setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		setProperty("hibernate.show_sql", "true");
		setProperty("hibernate.hbm2ddl.auto", "create");
		setProperty("cache.provider_class", "org.hibernate.NoCacheProvider");
	}};
	
	@SuppressWarnings("serial")
	private Properties csvProperties = new Properties() {{
		setProperty("separator", "|");              // separator is a bar
		setProperty("suppressHeaders", "false");    // column headers are on the first line
		setProperty("fileExtension", ".txt");       // file extension is .txt
		setProperty("charset", "UTF-8");       // file encoding is "ISO-8859-2"
		setProperty("commentLine", "--");           // string denoting comment line is "--"
	}};
	
	//------ CONFIGS -----------
	
}
