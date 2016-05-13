/*
 * Copyright (c) 2007-2013 Sonatype, Inc. All rights reserved.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse
 * Public License Version 1.0, which accompanies this distribution and is available at
 * http://www.eclipse.org/legal/epl-v10.html.
 */
package com.sonatype.nexus.perftest;

import java.util.concurrent.TimeUnit;

import javax.management.StandardMBean;

/**
 * JMX endpoint for ClientSwarm.
 */
public class ClientSwarmMBeanImpl
    extends StandardMBean
    implements ClientSwarmMBean
{
  private final ClientSwarm clientSwarm;

  public ClientSwarmMBeanImpl(final ClientSwarm clientSwarm) {
    super(ClientSwarmMBean.class, false);
    this.clientSwarm = clientSwarm;
  }

  @Override
  public String getName() {
    return clientSwarm.getSwarmName();
  }

  @Override
  public int getRateSleepPeriod() {
    return clientSwarm.getRate().getPeriodMillis();
  }

  @Override
  public void setRateSleepPeriod(final int sp) {
    clientSwarm.getRate().setPeriodMillis(sp);
  }

  @Override
  public String getRatePeriod() {
    int period = (int) TimeUnit.SECONDS.toMillis(1) / getRateSleepPeriod();
    return period + "/" + TimeUnit.SECONDS.name();
  }

  @Override
  public void setRatePeriod(final String value) {
    setRateSleepPeriod(RequestRate.parsePeriod(value));
  }
}
