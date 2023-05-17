package top.code2022;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.code2022.dao.ItemMapper;
import top.code2022.pojo.Item;
import top.code2022.service.ItemService;

import java.util.List;

@SpringBootTest
class ManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private ItemService itemServiceImpl;

    @Test
    public void testFindItemsByPage() {
        List<Item> rows = itemServiceImpl.findItemsByPage(1, 1).getRows();
        rows.forEach(System.out::println);
    }


    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void testInsertItem(){
        Item item = new Item();
        item.setTitle("测试商品");
        item.setSellPoint("测试商品");
        item.setPrice(1000L);
        item.setNum(100);
        item.setBarcode("123456789");
        item.setImage("https://image.code2022.top/1.jpg");
        item.setCid(560);
        item.setStatus(1);
        int i = itemMapper.insertItem(item);
        System.out.println(i);
        // 获取自增主键
        System.out.println(item.getId());
    }
}
