package db;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.category;

/**
 *
 * @author Anil
 */
public class listquery extends DBConnection implements Serializable{
    public List<category>  listcategory(){
    List<category> list=new ArrayList<category>();
        try {
            ps=connect().prepareStatement("select idCategory, name from category");
            category cat;
            rs=ps.executeQuery();
            while (rs.next()) {                
                cat=new category();
                cat.setIdCategory(rs.getInt("idCategory"));
                cat.setName(rs.getNString("name"));
                list.add(cat);
            }
            return list;
        } catch (Exception e) {
            return null;
        }
    }
}
