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

    key(KEY_G, onKeyDown = {
      myImage.oil
    })

    key(KEY_K, onKeyDown = {
      myImage.contour
    })

    key(KEY_D, onKeyDown = {
      myImage.edge
    })

    key(KEY_R, onKeyDown = {
      myImage.reload
    })

    key(KEY_O, onKeyDown = {
      myImage.rotateLeft
    })

    key(KEY_P, onKeyDown = {
      myImage.rotateRight
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
    areaForMessage("message", Vec(700, 200), 16)
    
val xText = 700
    interface{
        print("OPTIONS", Vec(770,490), BLACK)
        print("Right Key - next image", Vec(xText, 470), BLACK)
        print("Left Key - previous image", Vec(xText, 450), BLACK)
        print("S - save changes", Vec(xText, 430), BLACK)
        print("R - reload", Vec(xText, 410), BLACK)
        print("E - exit", Vec(xText, 390), BLACK)
        print("X - flipX", Vec(xText, 350),  BLACK)
        print("Y - flipY", Vec(xText, 330), BLACK)
        print("O - rotate left", Vec(xText, 310),  BLACK)
        print("P - rotate right", Vec(xText, 290), BLACK)

	    print("FILTERS:", Vec(xText, 250), BLACK)
        print("B - blur", Vec(xText, 230), BLACK)
        print("M - bright", Vec(xText, 210), BLACK)
        print("F - frame", Vec(xText, 190), BLACK)
        print("C - chrome", Vec(xText, 170), BLACK)
        print("G - oil", Vec(xText, 150), BLACK)
        print("K - contour", Vec(xText, 130), BLACK)
        print("D - edge", Vec(xText, 110), BLACK)
     }


    action(1){

    }

    render{
        drawDisplayList(myImage.scageImageResult, Vec(350,320))
    }


}
