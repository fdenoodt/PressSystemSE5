package be.springPressOrder;

import be.springPressOrder.configuration.RepositoryConfiguration;
import be.springPressOrder.dao.PressOrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {RepositoryConfiguration.class})
public class PressOrderRepositoryTest {

    private PressOrderRepository pressOrderRepository;

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Test
    public void testSaveProduct(){
        //setup pressOrder
       /* PressOrder pressOrder = new PressOrder();
        pressOrder.setDescription("Spring Framework Guru Shirt");
        pressOrder.setPrice(new BigDecimal("18.95"));
        pressOrder.setProductId("1234");

        //save pressOrder, verify has ID value after save
        assertNull(pressOrder.getId()); //null before save
        pressOrderRepository.save(pressOrder);
        assertNotNull(pressOrder.getId()); //not null after save

        //fetch from DB
        PressOrder fetchedPressOrder = pressOrderRepository.findOne(pressOrder.getId());

        //should not be null
        assertNotNull(fetchedPressOrder);

        //should equal
        assertEquals(pressOrder.getId(), fetchedPressOrder.getId());
        assertEquals(pressOrder.getDescription(), fetchedPressOrder.getDescription());

        //update description and save
        fetchedPressOrder.setDescription("New Description");
        pressOrderRepository.save(fetchedPressOrder);

        //get from DB, should be updated
        PressOrder fetchedUpdatedPressOrder = pressOrderRepository.findOne(fetchedPressOrder.getId());
        assertEquals(fetchedPressOrder.getDescription(), fetchedUpdatedPressOrder.getDescription());

        //verify count of products in DB
        long productCount = pressOrderRepository.count();
        assertEquals(productCount, 1);

        //get all products, list should only have one
        Iterable<PressOrder> products = pressOrderRepository.findAll();

        int count = 0;

        for(PressOrder p : products){
            count++;
        }

        assertEquals(count, 1);*/
    }
}
