package com.TaskManagerApi.dto;

import com.TaskManagerApi.model.Task;
import com.TaskManagerApi.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {

    private String text;
    private int taskId;

}
