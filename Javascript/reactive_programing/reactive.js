/*

    ____                  __  _               ____                                                  _            
   / __ \___  ____ ______/ /_(_)   _____     / __ \_________  ____ __________ _____ ___  ____ ___  (_)___  ____ _
  / /_/ / _ \/ __ `/ ___/ __/ / | / / _ \   / /_/ / ___/ __ \/ __ `/ ___/ __ `/ __ `__ \/ __ `__ \/ / __ \/ __ `/
 / _, _/  __/ /_/ / /__/ /_/ /| |/ /  __/  / ____/ /  / /_/ / /_/ / /  / /_/ / / / / / / / / / / / / / / / /_/ / 
/_/ |_|\___/\__,_/\___/\__/_/ |___/\___/  /_/   /_/   \____/\__, /_/   \__,_/_/ /_/ /_/_/ /_/ /_/_/_/ /_/\__, /  
                                                           /____/                                       /____/   


 Reactive programming is a paradigm that works with asynchronous data steams. Everything is considered a data stream and enities can emit he data streams  or even latch on to a data stream to respond to these events

 Data streams can be anything
 -> UI events
 -> Http requests
 -> File systems
 -> Array-like Objects
 -> Memory / Cache

  -<Stream>-
  A Stream is a sequence of events ordered in time. It Emits a 'value','error' and a 'completed' signal

  -<Observables and observer>-
  We work with streams using obersvables. Observables are used to watch these streams and emit functions when a value/error/completed signal is returned

  Observables can be subscribed to by any observer. These observables will constantly watch streams and will update accordingly upon which all subscribed observers may choose to act. We can interact with data streams as any regular array.

  -<Reactive extensions>-
  ES5 and ES6 do not support reactive paradigm natively hence we use library extensions like RxJs or BaconJs or libraries like that (ReactiveX)
  They provide excellent operstors and methods to filter,select, tranform, combine and compose observables

*/