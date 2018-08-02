package com.monsanto.mbt;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class ShipmentTest {
    private List<Widget> widgets;
    private long widgetCount;

    @Test
    public void testShipment_Sorted_By_Color(){
    	  widgets = WidgetUtils.getSampleWidgets();
          widgetCount = widgets.size();
          
        //Implement your solution to get list of shipments
        List<Widget> widgetsSortedByColor = widgets
                .stream()
                .sorted(Comparator.comparing(Widget::getColor))
                .collect(Collectors.toList());
        List<Shipment> shipments = new ArrayList<>();
        for (int i = 0; i < 3 ; i++) {
            Shipment shipment = new Shipment();
            while (!shipment.isFull() && widgetsSortedByColor.size() > 0) {
                Widget widget = widgetsSortedByColor.get(0);
                shipment.addWidget(widget);
                widgetsSortedByColor.remove(widget);
            }
            shipments.add(shipment);
        }
        /* total around 25 element so 3 shipment will be create 1. 10 ,  2. 10 and 3. 5*/
        
        /* first shipment creation*/
        System.out.println("shipment 1");
        Shipment shipment =  shipments.get(0);
        	for(Widget widget : shipment.getWidgets()){
        		System.out.println(widget.getColor() + " " + widget.getSerialNumber() + " " + widget.getProductionDate());
        	}
        	System.out.println("shipment 2");
        	 /* second shipment creation*/
        Shipment shipment1 =  shipments.get(1);
        	for(Widget widget : shipment1.getWidgets()){
        		System.out.println(widget.getColor() + " " + widget.getSerialNumber() + " " + widget.getProductionDate());
        	}
        	System.out.println("shipment 3");
        	 /* third shipment creation*/
        Shipment shipment2 =  shipments.get(2);
        	for(Widget widget : shipment2.getWidgets()){
        		System.out.println(widget.getColor() + " " + widget.getSerialNumber() + " " + widget.getProductionDate());
        	}
    }

    @Test
    public void testShipment_Sorted_By_Date(){
        //Implement your solution to get list of shipments
    	 widgets = WidgetUtils.getSampleWidgets();
         widgetCount = widgets.size();
         
        List<Widget> widgetsSortedByDate = widgets
                .stream()
                .sorted(Comparator.comparing(Widget::getProductionDate))
                .collect(Collectors.toList());
        List<Shipment> shipments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Shipment shipment = new Shipment();
            while (!shipment.isFull() && widgetsSortedByDate.size() > 0) {
                Widget widget = widgetsSortedByDate.get(0);
                shipment.addWidget(widget);
                widgetsSortedByDate.remove(widget);
            }
            shipments.add(shipment);
        }

    }
}
