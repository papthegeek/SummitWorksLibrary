/**
 * 
 */
package pack;

import java.sql.Date;

/**
 * @author cheikh & papa
 *
 */
public interface Reference {
  String Id = "";
  String title = "";
  String author = "";
  Date publishedDate = new Date(0000, 00, 00);
  String language = "";
  String cathegory = "";
  String theme = "";
  
  public void setId(String id);
  public void setTitle(String title);
  public void setAuthor(String author);
  public void setPublishedDate(Date date);
  public void setLanguage(String language);
  public void setCathegory(String cathegory);
  public void setTheme(String theme);
  
  String getId(String id);
  String getTitle(String title);
  String getAuthor(String author);
  Date getPublishedDate(Date date);
  String getLanguage(String language);
  String getCathegory(String cathegory);
  String getTheme(String theme);
  
}
