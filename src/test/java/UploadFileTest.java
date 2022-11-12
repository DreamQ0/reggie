import org.junit.jupiter.api.Test;

/**
 * @author 刘圣琦
 * @create 2022-11-05-17:22
 */
public class UploadFileTest {
    @Test
    public void test1(){
        String fileName ="errerwewe.jpg";
        String substring = fileName.substring(fileName.lastIndexOf("."));
        System.out.println(substring);
    }
}
