package com.blog.ljw.firstbolg.persistence;

import com.blog.ljw.firstbolg.pojo.Tag;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TagMapper {
    String TABLE_NAEM = " tag ";
    String INSERT_FIELDS = " name, count ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into",TABLE_NAEM,"(",INSERT_FIELDS,") values (#{name},#{count})"})
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertTag(Tag tag);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM,"where name=#{name}"})
    Tag selectByName(String name);

    @Select({"select",SELECT_FIELDS,"from",TABLE_NAEM})
    List<Tag> selectAll();

    @Select({"select count(id) from",TABLE_NAEM})
    int getTagCount();

    @Update({"update",TABLE_NAEM,"set count = #{count} where id = #{tagId}"})
    void updateCount(@Param("tagId") int tagId, @Param("count") int count);

    @Delete({"delete from",TABLE_NAEM,"where id=#{id}"})
    void deleteById(int id);
}
