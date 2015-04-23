package ua.com.goit.gojava.andriidnikitin.MyShop.ui.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.context.RequestContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
@ManagedBean(name = "siteBean")
@RequestScoped
public class SiteBean implements Serializable{

	private static final String CONSTRUCT_PAGE = "patterns/construct.xhtml";
	private static final String ADMIN_TOOLBAR = "top/admin_topbar.xhtml";

	private static final long serialVersionUID = 2L;


	@ManagedProperty(value="#{content}")
	private String content;	

	@ManagedProperty(value="#{sidebar}")
	private String sidebar = "sidebar/catalog_editor.xhtml";
	
	@ManagedProperty(value="#{top}")
	private String top = "top/admin_topbar.xhtml";	

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

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
		top = ADMIN_TOOLBAR;
		content = CONSTRUCT_PAGE;
		sidebar = "patterns/empty.xhtml";
		updateCenter();
	}
	
	public void openWarehouse(){
		top = ADMIN_TOOLBAR;
		content = "content/edit_good_record.xhtml";
		sidebar = "patterns/empty.xhtml";
		updateCenter();
	}
	
	public void openCatalogEditor(){
		top = ADMIN_TOOLBAR;
		content = "patterns/empty.xhtml";
		sidebar = "sidebar/catalog_editor.xhtml";
		updateCenter();
	}
	
	public void openGoodEditor(){
		top = ADMIN_TOOLBAR;
		content = "content/edit_good.xhtml";
		updateCenter();
	}
	
	public void openTypeEditor(){
		top = ADMIN_TOOLBAR;
		content = "content/edit_good_type.xhtml";
		updateCenter();
	}


	private void updateCenter() {
		RequestContext.getCurrentInstance().update(":mainLayout:center");
	}

	private void updateTop() {
		RequestContext.getCurrentInstance().update(":mainLayout:north");
	}
	
	private void updateLeftSide() {
		RequestContext.getCurrentInstance().update(":mainLayout:west");
	}
}