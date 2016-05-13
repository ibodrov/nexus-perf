/*
 * Copyright (c) 2007-2013 Sonatype, Inc. All rights reserved.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License Version 1.0, which accompanies this distribution and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 */
package com.sonatype.nexus.perftest;

/**
 * JMX endpoint for ClientSwarm.
 */
public interface ClientSwarmMBean
{
  String getName();

  int getRateSleepPeriod();

  void setRateSleepPeriod(int sp);

  String getRatePeriod();

  void setRatePeriod(String value);

  int getToDoCount();

  int getWaitingCount();

  int getMultiplier();

  void setMultiplier(final int multiplier);
}
