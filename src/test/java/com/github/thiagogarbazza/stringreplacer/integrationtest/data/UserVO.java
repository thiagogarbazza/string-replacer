package com.github.thiagogarbazza.stringreplacer.integrationtest.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.JANUARY;
import static java.util.Calendar.JULY;
import static java.util.Calendar.MAY;
import static java.util.Calendar.OCTOBER;
import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
public class UserVO {

  private Calendar creationDate;
  private String email;
  private String id;
  private String name;

  public static UserVO buildHanSolo() {
    UserVO user = UserVO.builder()
        .id("be0f7d66-1d0e-4089-9ec9-55c85f96a831")
        .name("Han Solo")
        .email("solo.han@starwars.com")
        .creationDate(new GregorianCalendar(1950, OCTOBER, 25, 13, 15, 34))
        .build();

    return user;
  }

  public static UserVO buildLukeSkywalker() {
    UserVO user = UserVO.builder()
        .id("cf77b71e-5275-490c-b64f-9b78ff94785a")
        .name("Luke Skywalker")
        .email("skywalker.luke@starwars.com")
        .creationDate(new GregorianCalendar(1970, MAY, 4, 7, 53, 18))
        .build();

    return user;
  }

  public static UserVO buildMaceWindu() {
    UserVO user = UserVO.builder()
        .id("66477f01-8a9c-4668-8c4f-95108dba5c16")
        .name("Mace Windu")
        .email("windu.mace@starwars.com")
        .creationDate(new GregorianCalendar(1923, JANUARY, 1, 6, 32, 48))
        .build();

    return user;
  }

  public static UserVO buildThiagoGarbazza() {
    UserVO user = UserVO.builder()
        .id("a3381700-d485-4648-8549-829c4b036005")
        .name("Thiago Garbazza")
        .email("thiagogarbazza@gmail.com")
        .creationDate(new GregorianCalendar(1984, JULY, 20, 5, 45, 00))
        .build();

    return user;
  }
}
