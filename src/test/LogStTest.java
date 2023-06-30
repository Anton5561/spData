import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.denis.all.controller.LogSt;
import ru.denis.all.fox.Hen;


@ExtendWith({MockitoExtension.class})
public class LogStTest {

    @Mock
    Hen hen;
    @InjectMocks
    LogSt logSt;

    @Test
    @DisplayName("Проверяет метод")
    public void logSt_ReturnValid() {

        Mockito.doReturn("hynny").when(this.hen).getHen();

        Assertions.assertEquals("CATERPILLAR hynny", logSt.getCat());
    }

    @Test
    public void logdd() {



        Assertions.assertEquals("TEST page", logSt.getEr());

        Mockito.verifyNoInteractions(hen);

    }


}
