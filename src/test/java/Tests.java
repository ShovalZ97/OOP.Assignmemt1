import observer.ConcreteMember;
import observer.GroupAdmin;
import observer.Member;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        GroupAdmin adminsTest = new GroupAdmin();
        ConcreteMember s1 = new ConcreteMember("Alice") ;
        ConcreteMember s2 = new ConcreteMember("Bob");
        System.out.println("FootPrint - Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println(adminsTest.toStringData());
        System.out.println("Register members: ");
        adminsTest.register(s1);
        adminsTest.register(s2);
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after register members ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("append Shoval: ");
        adminsTest.append("Shoval");
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after add Shoval ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("unRegister s1: ");
        adminsTest.unregister(s1);
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after unRegister s1 ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("insert Rotem after char 1: ");
        adminsTest.insert(1,"Rotem");
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after insert Rotem ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("append Ziv:");
        adminsTest.append("Ziv");
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after append Ziv ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("undo:");
        adminsTest.undo();
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after undo ,Size of object and his content");
        logger.info(()->JvmUtilities.objectFootprint(adminsTest,s1,s2));

        System.out.println("delete:");
        adminsTest.delete(0,1);
        System.out.println(adminsTest.toStringData());
        System.out.println("FootPrint - after delete ,Size of object and his content");
        logger.info(()->JvmUtilities.objectTotalSize(adminsTest,s1,s2));

        System.out.println();
        System.out.println("Info:");
        logger.info(() -> JvmUtilities.jvmInfo());
    }
}
