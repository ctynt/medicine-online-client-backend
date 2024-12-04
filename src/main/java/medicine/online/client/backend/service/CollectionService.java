package medicine.online.client.backend.service;

/**
 * @author WangL
 */
public interface CollectionService {

    /**
     * 删除收藏
     */
    boolean deleteCollection(Integer contentId, Integer type);

    /**
     * 添加收藏
     */
    boolean addCollection(Integer contentId, Integer type);

}