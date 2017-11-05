package com.github.thiagogarbazza.stringreplacer.integrationtest.data;

import com.github.thiagogarbazza.stringreplacer.Replacer;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class Replacers extends ArrayList<Replacer> {

  public Replacers() {
    super(asList(
        new ReplacerUserCreationDate(),
        new ReplacerUserEmail(),
        new ReplacerUserId(),
        new ReplacerUserName()
                ));
  }
}
