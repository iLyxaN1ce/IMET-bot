const stages = [
  {
    "command": "",
    "stageName": "nullStage",
    "text": "",
    "commandStageMap": {}
  },
  {
    // might be called from any stage
    "command": "/start",
    "stageName": "start",
    "text": "Привет! Я бот ИПМЭиТ и я готов ответить на твои вопросы! Напиши /help, чтобы узнать, что я умею",
    "commandStageMap": {}
  },
  {
    "command": "/initChain",
    "stageName": "initChain",
    "text": "You've entered dialog chain",
    "commandStageMap": {
      "/continueChain": "continueChain"
    }
  },
  {
    // hidden for user
    "command": "",
    "stageName": "continueChain",
    "text": "You're in the middle of dialog chain",
    "commandStageMap": {
      "/endChain": "endChain"
    }
  },
  {
    "command": "",
    "stageName": "endChain",
    "text": "You're at the end of dialog chain",
    "commandStageMap": {}
  }
]