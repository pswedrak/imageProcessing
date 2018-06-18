import com.github.dunnololda.scage.ScageLib._
import com.sksamuel.scrimage._
import com.sksamuel.scrimage.filter._
import com.sksamuel.scrimage.X11Colorlist._
import java.io.File._
import java.io._
import javax.imageio.ImageIO
import java.util.Scanner

object Main extends ScageScreenApp("Scage App", 1000, 640){

    backgroundColor = WHITE

    val album = new ImageAlbum("resources/images/")
    var currentImage = 0 
    var myImage = album.images(currentImage)
    

    key(KEY_X, onKeyDown = {
      myImage.flipX
    })


    key(KEY_Y, onKeyDown = {
      myImage.flipY
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

    key(KEY_RIGHT, onKeyDown = {
      currentImage = (currentImage + 1) % album.imagesCounter
      myImage = album.images(currentImage)
    })

    key(KEY_LEFT, onKeyDown = {
      currentImage = (currentImage - 1) 
      if(currentImage < 0) currentImage = album.imagesCounter - 1
      myImage = album.images(currentImage)
    })

    key(KEY_S, onKeyDown = {
      myImage.save
    })

    key(KEY_E, onKeyDown = {
      stopApp()
    })

clear{
      for (image <- album.images) {
        image.resultFile.delete
      }
}

    interface{
        print("options", Vec(770,450), RED)
        print("X - flipX", Vec(680,430), RED)
        print("Y - flipY", Vec(680,410), RED)
        print("B - blur filter", Vec(680,390), RED)
        print("M - bright filter", Vec(680,370), RED)
        print("R - reload", Vec(680,350), RED)
        print("F - frame", Vec(680,330), RED)
        print("C - chrome", Vec(680,310), RED)
        print("Right Key - next image", Vec(680,290), RED)
        print("Left Key - previous image", Vec(680,270), RED)
        print("S - save changes", Vec(680,250), RED)
        print("E - exit", Vec(680,230), RED)
     }


    action(1){

    }

    render{
        drawDisplayList(myImage.scageImageResult, Vec(250,300))
    }


}
