import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemServiceMap implements IServiceItem{

    private Map<String, Item> itemMap;

    public ItemServiceMap(){
        itemMap = new HashMap<String, Item>();
    }

    @Override
    public Collection<Item> getItemsUsers(String userName) {
        Collection<Item> itemsUser = itemMap.values();
        Map<String, Item> itemFilter = new HashMap<String, Item>();
        itemsUser.forEach(i -> {
            if(i.getNameUser().equalsIgnoreCase(userName)){
                itemFilter.put(i.getName(),i);
            }
        });
        return itemFilter.values();
    }

    @Override
    public Long postloginUser() {
        return null;
    }

    @Override
    public String getSite(String token, String user) {
        return null;
    }

    @Override
    public Item getItem(String id) {
        return itemMap.get(id);
    }

    @Override
    public String getCategory(String token, String user, String idSite) {
        return null;
    }

    @Override
    public String postItem(String token, String user, String idSite, String idCategori) {
        return null;
    }

    @Override
    public Collection<Item> getItems() {
        return itemMap.values();
    }


    @Override
    public Item getItemUser(Item item, String username) {
        return null;
    }

    @Override
    public int addItem(Item item) throws ApiException {
        itemMap.put(item.getId(), item);
        return itemMap.size();
    }

    @Override
    public Item updateItem(String id, Item item) throws ApiException {
        itemMap.replace(item.getId(), item);
        return itemMap.get(id);
    }
}


/*

@Override
    public int addItem(Item item) throws ApiException {
        itemMap.put(item.getId(), item);
        return itemMap.size();

@Override
    public Collection<Item> getItems() {
        return itemMap.values();
    }
@Override
    public Site updateSite(String id, Site site) throws ApiException {
        siteMap.replace(site.getId(), site);
        return site;
    }
* */
