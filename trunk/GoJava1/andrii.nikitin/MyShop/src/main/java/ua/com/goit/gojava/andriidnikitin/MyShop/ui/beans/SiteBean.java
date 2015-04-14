package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@ManagedBean(name = "siteBean")
@RequestScoped
public class SiteBean implements Serializable{

	private static final long serialVersionUID = 2L;


	@ManagedProperty(value="#{content}")
	private String content;	

	@ManagedProperty(value="#{sidebar}")
	private String sidebar;

	public String getSidebar() {
		return sidebar;
	}

	public void setSidebar(String sidebar) {
		this.sidebar = sidebar;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public void openConstruct(){
		content = "patterns/construct.xhtml";
		sidebar = "patterns/empty.xhtml";
	}
	
	public void openWarehouse(){
		content = "content/edit_good_record.xhtml";
		sidebar = "patterns/empty.xhtml";
	}
	
	public void openCatalogEditor(){
		content = "patterns/empty.xhtml";
		sidebar = "sidebar/catalog_editor.xhtml";
	}
	
	public void openGoodEditor(){
		content = "content/edit_good.xhtml";
		sidebar = "sidebar/catalog_editor.xhtml";
	}
	
	public void openTypeEditor(){
		content = "content/edit_good_type.xhtml";
		sidebar = "sidebar/catalog_editor.xhtml";
	}
}