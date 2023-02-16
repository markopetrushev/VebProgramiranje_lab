package mk.ukim.finki.wp.lab;

import mk.ukim.finki.wp.lab.model.Balloon;
import mk.ukim.finki.wp.lab.model.Manufacturer;
import mk.ukim.finki.wp.lab.repository.jpaRepository.BalloonRepository;
import mk.ukim.finki.wp.lab.service.impl.BalloonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class addNewBallooonTest {
    @Mock
    private BalloonRepository balloonRepository;
    private BalloonServiceImpl balloonService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);

        this.balloonService = Mockito.spy(new BalloonServiceImpl(this.balloonRepository));


        Balloon balloon = new Balloon("name","description", new Manufacturer("BalloonManuf1", "Macedonia", "DushanTaskovich 1a"));
        Mockito.when(this.balloonRepository.save(Mockito.any(Balloon.class))).thenReturn(balloon);

    }

//    @Test
//    public void testSuccessSave(){
//        Balloon balloon = this.balloonService.createBalloon("name","description", new Manufacturer("BalloonManuf2", "Macedonia", "Gemidziska 44a"));
//        Mockito.verify(this.balloonService).createBalloon("name","description", new Manufacturer("BalloonManuf2", "Macedonia", "Gemidziska 44a"));
//
//        Assert.assertNotNull("Balloon is null",balloon);
//        Assert.assertEquals("Name does not match","name",balloon.getName());
//        Assert.assertEquals("Description does not match","description",balloon.getDescription());
//        Assert.assertEquals("Manufacturer does not match",new Manufacturer("BalloonManuf2", "Macedonia", "Gemidziska 44a"),balloon.getManufacturer());
//    }
//
//    @Test
//    public void testNameNull(){
//        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
//                ()->this.balloonService.createBalloon(null,"description",new Manufacturer("BalloonManuf3", "Macedonia", "Gemidziska 43a")));
//        Mockito.verify(this.balloonService).createBalloon(null,"description",new Manufacturer("BalloonManuf3", "Macedonia", "Gemidziska 43a"));
//    }
//
//    @Test
//    public void testDescNull(){
//        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
//                ()->this.balloonService.createBalloon("name",null,new Manufacturer("BalloonManuf4", "Macedonia", "Gemidziska 45b")));
//        Mockito.verify(this.balloonService).createBalloon("name",null,new Manufacturer("BalloonManuf4", "Macedonia", "Gemidziska 45b"));
//    }
//
//    @Test
//    public void testManNull(){
//        Assert.assertThrows("IllegalArgumentException expected",IllegalArgumentException.class,
//                ()->this.balloonService.createBalloon("name","description",null));
//        Mockito.verify(this.balloonService).createBalloon("name","description",null);
//    }
}
