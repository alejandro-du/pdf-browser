package org.vaadin.alejandro;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.server.StreamRegistration;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.server.StreamResourceRegistry;
import com.vaadin.flow.server.VaadinSession;

import java.net.URI;

@NpmPackage(value = "@lrnwebcomponents/pdf-browser-viewer", version = "2.7.10")
@JsModule("@lrnwebcomponents/pdf-browser-viewer/pdf-browser-viewer.js")
@Tag("pdf-browser-viewer")
public class PdfBrowserViewer extends Component {

    private StreamRegistration streamRegistration;

    public PdfBrowserViewer() {
    }

    public PdfBrowserViewer(StreamResource streamResource) {
        setStreamResource(streamResource);
    }

    public void setStreamResource(StreamResource streamResource) {
        unregister();
        streamRegistration = VaadinSession.getCurrent().getResourceRegistry().registerResource(streamResource);
        URI uri = StreamResourceRegistry.getURI(streamResource);
        setFile(uri.toASCIIString());
    }

    public void setFile(String file) {
        getElement().setAttribute("file", file);
    }

    public void setNotSupportedMessage(String message) {
        getElement().setAttribute("not-supported-message", message);
    }

    public void setNotSupportedLinkMessage(String message) {
        getElement().setAttribute("not-supported-link-message", message);
    }

    public void setCard(boolean card) {
        getElement().setAttribute("card", card);
    }

    public void setDownloadLabel(String label) {
        getElement().setAttribute("downloadLabel", label);
    }

    public void setElevation(String elevation) {
        getElement().setAttribute("elevation", elevation);
    }

    public void setHeight(String height) {
        getElement().setAttribute("height", height);
        getElement().getStyle().set("height", height);
    }

    public void setWidth(String width) {
        getElement().setAttribute("width", width);
        getElement().getStyle().set("width", width);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        super.onDetach(detachEvent);
        unregister();
    }

    private void unregister() {
        if (streamRegistration != null) {
            streamRegistration.unregister();
        }
    }
}
