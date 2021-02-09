package com.grofers.luckydraw.exceptions;

public class RaffleTicketForTheDayExistsException extends RuntimeException {

  public RaffleTicketForTheDayExistsException(long mobileNum, String name) {
    super(name + " with mobileNum " + mobileNum + " has already received today's raffle ticket.");
  }
}
