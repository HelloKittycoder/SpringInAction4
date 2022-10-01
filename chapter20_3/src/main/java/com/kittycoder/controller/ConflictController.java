package com.kittycoder.controller;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Controller;

/**
 * @author shucheng
 * @date 2022/10/1 15:30
 */
@ManagedResource(objectName = "spitter:name=SpittleController")
@Controller
public class ConflictController {

    private int spittlesPerPage = 10;

    @ManagedAttribute
    public int getSpittlesPerPage() {
        return spittlesPerPage;
    }

    @ManagedAttribute
    public void setSpittlesPerPage(int spittlesPerPage) {
        this.spittlesPerPage = spittlesPerPage;
    }
}
