package com.example.timedealserver.domain.timedeal.controller;

import com.example.timedealserver.domain.timedeal.dto.request.TimeDealAddRequestDto;
import com.example.timedealserver.domain.timedeal.service.TimeDealService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/timedeal")
@RequiredArgsConstructor
@RestController
public class TimeDealController {

    private final TimeDealService timeDealService;

    @PostMapping
    public ResponseEntity<Long> addTimeDeal(@Valid @RequestBody TimeDealAddRequestDto timeDealAddRequestDto,
                                            HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        Long id = timeDealService.addTimeDeal(session, timeDealAddRequestDto);

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @DeleteMapping("/{timedealId}")
    public ResponseEntity deleteTimeDeal(@PathVariable Long timedealId, HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        timeDealService.deleteTimeDeal(session, timedealId);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
