package me.vitblokhin.backend.dto;

import me.vitblokhin.backend.model.Role;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PageDtoTest {

    private Role testRole1 = new Role();
    private Role testRole2 = new Role();
    private List<Role> roleList = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        testRole1.setId(1L);
        testRole1.setName("Role1");
        testRole2.setId(2L);
        testRole2.setName("Role2");

        roleList.add(testRole1);
        roleList.add(testRole2);
    }

    @Test
    public void testConstructor(){
        Page<Role> testArgumentPage = new PageImpl<>(roleList);
        PageDto<RoleDto, Role> testDtoPage = new PageDto<>(testArgumentPage, RoleDto::new);

        assertEquals(0, testDtoPage.getPageNumber());
        assertEquals(1, testDtoPage.getTotalPages());
        assertEquals(roleList.size(), testDtoPage.getDtoList().size());
    }

}