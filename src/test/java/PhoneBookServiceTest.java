import com.litmos.gridu.config.WebConfig;
import com.litmos.gridu.exceptions.ResourceNotFoundException;
import com.litmos.gridu.models.Record;
import com.litmos.gridu.services.PhoneBookService;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class PhoneBookServiceTest {

    @Autowired
    private PhoneBookService service;

    Record record;
    String name;
    String phone1;
    String phone2;

    @Before
    public void initRecord(){
        name ="Darya";
        phone1 = "8888";
        phone2 = "7777";
        Set<String> phones = new HashSet<>();
        phones.add(phone1);
        phones.add(phone2);
        record = new Record(name, phones);
    }

    @Test
    public void addRecordTest() throws ResourceNotFoundException {
        service.addRecord(record);

        assertEquals("Record was added incorrect", record, service.findAllPhonesByName(name));
    }

    @Test
    public void deleteRecordTest() throws ResourceNotFoundException {
        service.addRecord(record);
        service.deleteRecord(name);

        assertTrue("Record wasn't deleted", service.findAllRecords().isEmpty());
    }

    @Test
    public void findAllRecordsTest() throws ResourceNotFoundException {
        service.addRecord(record);
        int countOfRecords = service.findAllRecords().size();

        assertTrue("Record was added incorrect", countOfRecords==1);
    }

    @Test
    public void updatePhoneTest() throws ResourceNotFoundException {
        String newPhone ="1111";
        Set<String> expectedPhones = new HashSet<>();
        expectedPhones.add(newPhone);
        expectedPhones.add(phone2);
        Record expectedRecord = new Record(name, expectedPhones);

        service.addRecord(record);
        service.updatePhone(name, newPhone, phone1 );

        assertEquals("Record wasn't update", expectedRecord, service.findAllPhonesByName(name));
    }


    @Test
    public void deletePhoneTest() throws ResourceNotFoundException {
        Set<String> expectedPhones = new HashSet<>();
        expectedPhones.add(phone1);
        Record expectedRecord = new Record(name, expectedPhones);

        service.addRecord(record);
        service.deletePhone(name, phone2);

        assertEquals("Phone wasn't deleted", expectedRecord, service.findAllPhonesByName(name));
    }

    @Test
    public void addPhoneToNameTest() throws ResourceNotFoundException {
        String newPhone ="1111";
        Set<String> expectedPhones = new HashSet<>();
        expectedPhones.add(phone1);
        expectedPhones.add(phone2);
        expectedPhones.add(newPhone);
        Record expectedRecord = new Record(name, expectedPhones);

        service.addRecord(record);
        service.addPhoneToName(name, newPhone);

        assertEquals("Phone wasn't added to record", expectedRecord, service.findAllPhonesByName(name));
    }
}
