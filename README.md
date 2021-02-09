<img src = "https://www.mediafire.com/convkey/ca21/ntn4bpkhx3lltu9zg.jpg">

<br>

### GET API

**WINNERS_API**

##### USAGE:
- `127.0.0.1:8081/luckydraw/winners`
- `127.0.0.1:8081/luckydraw/winners?rangeInDays=\<int>`

<br>

### POST API

**RAFFLE_TICKET_API**

##### USAGE:
- `127.0.0.1:8081/luckydraw/newRaffleTicket`
  - sampleRequestBody(JSON):
    ```json
    {
      "mobileNum": 919831284491,
      "name": "Ayush Kumar Shaw"
    }
    ```