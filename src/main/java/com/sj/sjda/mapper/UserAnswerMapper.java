package com.sj.sjda.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sj.sjda.model.dto.statistic.AppAnswerCountDTO;
import com.sj.sjda.model.dto.statistic.AppAnswerResultCountDTO;
import com.sj.sjda.model.entity.UserAnswer;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author start
* @description 针对表【user_answer(用户答题记录)】的数据库操作Mapper
* @createDate 2024-08-06 15:35:31
* @Entity com.sj.sjda.model.entity.UserAnswer
*/
public interface UserAnswerMapper extends BaseMapper<UserAnswer> {
    @Select("select appId, count(userId) as answerCount from user_answer\n" +
            "    group by appId order by answerCount desc limit 10;")
    List<AppAnswerCountDTO> doAppAnswerCount();


    @Select("select resultName, count(resultName) as resultCount from user_answer\n" +
            "    where appId = #{appId}\n" +
            "    group by resultName order by resultCount desc;")
    List<AppAnswerResultCountDTO> doAppAnswerResultCount(Long appId);
}




