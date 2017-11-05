package com.github.thiagogarbazza.stringreplacer.integrationtest.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Calendar;

import static lombok.AccessLevel.PRIVATE;

@Getter
@Builder
@AllArgsConstructor(access = PRIVATE)
public class UserFileVO {

  private Calendar creationDate;
  private String id;
  private String name;
  private String type;
}
