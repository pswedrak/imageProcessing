import com.github.dunnololda.scage.ScageLib._
import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.X11Colorlist._
import java.io.File._
import java.io._
import javax.imageio.ImageIO


object Main extends ScageScreenApp("Scage App", 1000, 640){

    backgroundColor = WHITE
    var myImage = new MyImage("dice.png")


    key(KEY_X, onKeyDown = {
      myImage.flipX
    })


    key(KEY_Y, onKeyDown = {
      myImage.flipX
    })

    key(KEY_F, onKeyDown = {
      myImage.frame
    })

    key(KEY_B, onKeyDown = {
      myImage.blur
    })

    key(KEY_M, onKeyDown = {
      myImage.bright
    })

    key(KEY_C, onKeyDown = {
      myImage.chrome
    })

    key(KEY_R, onKeyDown = {
      myImage.reload
    })

    interface{
        print("options", Vec(770,450), RED)
        print("X - flipX", Vec(680,430), RED)
        print("Y - flipY", Vec(680,410), RED)
        print("B - blur filter", Vec(680,390), RED)
        print("M - bright filter", Vec(680,370), RED)
        print("R - reload", Vec(680,350), RED)
        print("F - frame", Vec(680,330), RED)
        print("C - chrome", Vec(680,310), RED)
     }


    action(1){

    }

    render{
        drawDisplayList(myImage.scageImageResult, Vec(250,300))
    }


}
