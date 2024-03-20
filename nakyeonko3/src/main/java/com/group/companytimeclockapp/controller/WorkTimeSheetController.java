package com.group.companytimeclockapp.controller;

import com.group.companytimeclockapp.service.WorkTimeSheetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/workTimeSheets")
public class WorkTimeSheetController {

    private final WorkTimeSheetService workTimeSheetService;

    public WorkTimeSheetController(WorkTimeSheetService workTimeSheetService) {
        this.workTimeSheetService = workTimeSheetService;
    }

    @PostMapping("/clockIn")
    public void clockIn(@RequestParam long id){
        workTimeSheetService.clockIn(id);
    }

    @PutMapping("/clockOut")
    public void clockOut(@RequestParam long id){
        workTimeSheetService.clockOut(id);
    }


}
