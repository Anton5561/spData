import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.denis.all.fox.FoxyJ;

@ExtendWith({MockitoExtension.class})

public class FoxyTest2 {

    @Mock
    FoxyJ foxyJ;

    @Test
    public void getTest(){
        System.out.println(foxyJ.getRealName());
    }
}
