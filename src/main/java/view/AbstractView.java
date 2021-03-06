package view;

import org.gnome.gtk.Builder;
import org.gnome.gtk.Window;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Created by melkir on 02/03/15.
 */
public abstract class AbstractView {

    final Builder builder;
    final Window window;

    AbstractView(String filepath) {
        this.builder = new Builder();
        try {
            builder.addFromFile("resources/" + filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        window = (Window) builder.getObject("mainWindow");
        initComposant();
    }

    protected abstract void initComposant();

    public void addWindowCloseEvent(Window.DeleteEvent event) {
        window.connect(event);
    }

    public void setTitle(String title) {
        window.setTitle(title);
    }

    public void setVisible(boolean visible) {
        if (visible) window.showAll();
        else window.hide();
    }

}
