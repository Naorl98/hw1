import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.UndoableStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";
    	ConcreteMember a = new ConcreteMember();
		ConcreteMember b = new ConcreteMember();
		ConcreteMember c = new ConcreteMember();
		ConcreteMember d = new ConcreteMember();
		GroupAdmin admin = new GroupAdmin();
		admin.register(a);
		admin.register(b);
		admin.register(c);
		admin.register(d);
		admin.append(s1);
		logger.info(()->JvmUtilities.objectFootprint(a));
		logger.info(()->JvmUtilities.objectFootprint(b));
		logger.info(()->JvmUtilities.objectFootprint(d));

		logger.info(()->JvmUtilities.objectFootprint(a,b));
		logger.info(()->JvmUtilities.objectTotalSize(b));
		logger.info(()->JvmUtilities.objectTotalSize(d));

		logger.info(()->JvmUtilities.objectTotalSize(a));

		logger.info(() -> JvmUtilities.jvmInfo());
		assertEquals(a.getUsb().toString(), s1);
		assertEquals(a.getUsb().toString(), b.getUsb().toString());
		assertEquals(c.getUsb().toString(), b.getUsb().toString());
		assertEquals(d.getUsb().toString(), a.getUsb().toString());
		admin.unregister(d);
		admin.append(s2);
		assertEquals(a.getUsb().toString(), "AliceBob");
		assertEquals(a.getUsb().toString(), b.getUsb().toString());
		admin.unregister(d);
		admin.insert(5,",middle,");
		assertEquals(a.getUsb().toString(), "Alice,middle,Bob");
		assertEquals(b.getUsb().toString(), "Alice,middle,Bob");
		assertNotEquals(d.getUsb().toString(), "Alice,middle,Bob");
		admin.delete(5,13);
		assertEquals(a.getUsb().toString(), "AliceBob");
		assertNotEquals(b.getUsb().toString(), "Alice,middle,Bob");
		assertEquals(a.getUsb().toString(), c.getUsb().toString());
		assertNotEquals(b.getUsb().toString(), d.getUsb().toString());
		logger.info(()->JvmUtilities.objectFootprint(a));
		logger.info(()->JvmUtilities.objectFootprint(b));
		logger.info(()->JvmUtilities.objectFootprint(d));

		logger.info(()->JvmUtilities.objectFootprint(a,d));
		logger.info(()->JvmUtilities.objectTotalSize(b));
		logger.info(()->JvmUtilities.objectTotalSize(d));

		logger.info(()->JvmUtilities.objectTotalSize(a));

    }
}
