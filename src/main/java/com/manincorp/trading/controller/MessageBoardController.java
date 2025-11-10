package com.manincorp.trading.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.manincorp.trading.common.Result;
import com.manincorp.trading.dto.MessageBoardPageDTO;
import com.manincorp.trading.entity.MessageBoard;
import com.manincorp.trading.service.MessageBoardService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * author: Jamie
 * Package: com.manincorp.trading.controller.MessageBoardController
 * Date: 2025-11-10 11:40
 * Description:
 */
@RestController
@RequestMapping("/messageBoard")
public class MessageBoardController {

    @Resource
    private MessageBoardService messageBoardService;

    /**
     * add
     */
    @PostMapping("/add")
    public Result add(@RequestBody MessageBoard messageBoard) {
        messageBoardService.save(messageBoard);
        return Result.success(messageBoard);
    }

    /**
     * delete
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        messageBoardService.removeById(id);
        return Result.success();
    }

    /**
     * Batch delete
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        messageBoardService.removeBatchByIds(ids);
        return Result.success();
    }

    /**
     * update
     */
    @PostMapping("/update")
    public Result updateById(@RequestBody MessageBoard messageBoard) {
        messageBoardService.updateById(messageBoard);
        return Result.success(messageBoard);
    }

    /**
     * Query by ID
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        MessageBoard messageBoard = messageBoardService.getById(id);
        return Result.success(messageBoard);
    }


    /**
     * Query all
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        List<MessageBoard> messageBoardlist = messageBoardService.list();
        return Result.success(messageBoardlist);
    }

    /**
     * page
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam Integer pageNum,
                             @RequestParam Integer pageSize,
                             MessageBoard messageBoard) {
        Page<MessageBoardPageDTO> page = new Page<>(pageNum, pageSize);
        IPage<MessageBoardPageDTO> list = messageBoardService.selectPage(page, messageBoard);
        return Result.success(list);
    }

}
