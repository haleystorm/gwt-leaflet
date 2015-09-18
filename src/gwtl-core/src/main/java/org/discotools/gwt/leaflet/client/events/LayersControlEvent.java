package org.discotools.gwt.leaflet.client.events;

import org.discotools.gwt.leaflet.client.jsobject.JSObject;
import org.discotools.gwt.leaflet.client.layers.ILayer;
import org.discotools.gwt.leaflet.client.layers.vector.Circle;
import org.discotools.gwt.leaflet.client.layers.vector.Polygon;
import org.discotools.gwt.leaflet.client.layers.vector.Polyline;
import org.discotools.gwt.leaflet.client.layers.vector.Rectangle;
import org.discotools.gwt.leaflet.client.marker.Marker;

public class LayersControlEvent extends
		Event
{

	protected LayersControlEvent() {
		super();
	}

	/**
	 * The original DOM mouse event fired by the browser.
	 *
	 * @return javascript object DOMMouseEvent
	 */
	public final native com.google.gwt.user.client.Event getOriginalEvent() /*-{
		return this.originalEvent;
	}-*/;

	/**
	 * Layer that was just created.
	 *
	 * @return
	 */
	public final ILayer getLayer() {
		String type = getLayerType();
		if ("polyline".equals(type)) {
			return new Polyline(
					layer());
		}
		else if ("polygon".equals(type)) {
			return new Polygon(
					layer());
		}
		else if ("rectangle".equals(type)) {
			return new Rectangle(
					layer());
		}
		else if ("circle".equals(type)) {
			return new Circle(
					layer());
		}
		else if ("marker".equals(type)) {
			return new Marker(
					layer());
		}
		else {
			return new ILayer(
					layer());
		}
	}

	private final native JSObject layer() /*-{
		return this.layer;
	}-*/;

	/**
	 * The type of layer this is. One of: polyline, polygon, rectangle, circle,
	 * marker
	 *
	 * @return
	 */
	public final String getLayerType() {
		return layerType();
	}

	private final native String layerType() /*-{
		return this.layerType;
	}-*/;

    /**
     * @return  The layer that was added or removed.
     */
    public final String getName() {
        return name();
    }

    protected final native String name()/*-{
        return this.name;
    }-*/;
}
