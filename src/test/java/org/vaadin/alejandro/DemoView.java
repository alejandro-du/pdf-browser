package org.vaadin.alejandro;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;

@Route("")
public class DemoView extends Div {

    public DemoView() {
        StreamResource streamResource = new StreamResource(
                "report.pdf", () -> getClass().getResourceAsStream("/report.pdf"));
        
        /* Or:
        StreamResource streamResource = new StreamResource(
            "report.pdf", () -> {
                try {
                  return FileUtils.openInputStream(new File("/Users/alejandro/report.pdf"));
                } catch (IOException e) {
                  e.printStackTrace();
                }
                return null;
            });
        */

        PdfBrowserViewer viewer = new PdfBrowserViewer(streamResource);
        viewer.setHeight("100%");
        add(viewer);
        setHeight("100%");
    }

}
