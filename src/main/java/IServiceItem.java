import java.util.Collection;

public interface IServiceItem {

    public Long postloginUser();

    public String getSite(String token, String user);

    public Item getItem(String id);

    public String getCategory(String token, String user, String idSite);

    public String postItem(String token, String user, String idSite, String idCategory);

    public Collection<Item> getItems();

    public Collection<Item> getItemsUsers(String UserName);

    public Item getItemUser(Item item, String username);

    public int addItem(Item item) throws ApiException;

    public Item updateItem(String id, Item item) throws ApiException;

}
