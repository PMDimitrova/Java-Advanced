package onlineShop.core;

import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.CentralProcessingUnit;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.components.*;
import onlineShop.models.products.peripherals.*;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new LinkedHashMap<>();
        this.components = new LinkedHashMap<>();
        this.peripherals = new LinkedHashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer,     //DONE
                              String model, double price) {
        if (computers.containsKey(id)){
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }

        Computer computer;

        if (computerType.equals("DesktopComputer")) {
            computer = new DesktopComputer(id, manufacturer, model, price);
        } else if (computerType.equals("Laptop")) {
            computer = new Laptop(id, manufacturer, model, price);
        } else {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
        computers.put(computer.getId(), computer);
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addComponent(int computerId, int id, String componentType,
                               String manufacturer, String model, double price,
                               double overallPerformance, int generation) {
        checkComputerID(computerId);

        if (components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        components.put(id, component);
        computers.get(computerId).addComponent(component);


        return String.format(ADDED_COMPONENT,
                componentType, id, computerId);
    }   //DONE

    @Override
    public String removeComponent(String componentType, int computerId) {
        checkComputerID(computerId);
        Component component = computers.get(computerId).removeComponent(componentType);
        components.remove(component.getId());

        return String.format(REMOVED_COMPONENT, componentType, computerId );
        //"Successfully removed %s with id %d."
    }       //DONE

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType,
                                String manufacturer, String model, double price,
                                double overallPerformance, String connectionType) {

        checkComputerID(computerId);

        if (peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance,connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance,connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance,connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance,connectionType);
                break;

            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        peripherals.put(id, peripheral);
        computers.get(computerId).addPeripheral(peripheral);


        return String.format(ADDED_PERIPHERAL,
                peripheralType, id, computerId);
    }   //DONE

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checkComputerID(computerId);
        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());

        return String.format(REMOVED_PERIPHERAL, peripheralType, computerId );
    }   //DONE

    @Override
    public String buyComputer(int id) {
        checkComputerID(id);
        Computer computer = computers.get(id);
        computers.remove(id);

        return computer.toString();
    } //TODO finish it; toString method is not complete

    @Override
    public String BuyBestComputer(double budget) {
        if (computers.isEmpty()){
            throw new IllegalArgumentException (String.format(CAN_NOT_BUY_COMPUTER, budget));
        }
        double minPrice = Double.MAX_VALUE;

        for (Map.Entry<Integer, Computer> comp: computers.entrySet()) {
            if (comp.getValue().getPrice()<minPrice){
                minPrice = comp.getValue().getPrice();
            }
        }
        if (minPrice>budget){
            throw new IllegalArgumentException (String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        List<Computer> filtered = computers.values()
                .stream()
                .filter(comp -> comp.getPrice() <= budget)
                .sorted(Comparator.comparing(Computer::getOverallPerformance).reversed())
                .collect(Collectors.toList());

        Computer computer = filtered.get(0);
        computers.remove(computer.getId());
        return computer.toString();
    } //DONE

    @Override
    public String getComputerData(int id) {
        checkComputerID(id);

        return computers.get(id).toString();
    } //DONE

    private void checkComputerID(int id) {
        if (!this.computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }
}
