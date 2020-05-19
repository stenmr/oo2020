package org.testing.website2.controllers;

import java.util.Calendar;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@Controller
public class CalendarController {

    @GetMapping("/calendar")
    public String calendar(@RequestParam(value = "add", defaultValue = "0") String add, Model model) {
        Locale locale = new Locale("et");
        Calendar calendar = Calendar.getInstance(locale);

        int number;
        try {
            number = Integer.parseInt(add);
        } catch (NumberFormatException e) {
            number = 0;
        }

        calendar.add(Calendar.DATE, number);

        String weekDay = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String month = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
        int year = calendar.get(Calendar.YEAR);

        model.addAttribute("add", number);
        model.addAttribute("date", weekDay + ", " + day + ". " + month + " " + year);
        return "calendar";
    }
}