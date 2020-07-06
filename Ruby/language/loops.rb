# how to loop throught array

# initializing ruby arrays
a = [1,2,3, 'test', [nil, 3.4], { test: true }]
a = Array.new(3) # => [nil, nil, nil]
a = Array.new(3, 'test') # => ['test', 'test', 'test']
a = Array.new(5) { |index| index * 2 } # => [ 0, 2, 4, 6, 8 ]


# ranges
r = (0..8) #=> inclusive range
r.to_a # =>  [ 0, 1, 2, 3, 4, 5, 6, 7, 8 ]

r = (0...8) #=> exclusive
r.to_a # => [ 0, 1, 2, 3, 4, 5, 6, 7 ]

# you can make custom ranges, just implement <=> and succ methods in your class and include Comparable mixin/module

# while loop
x = 4
while x >= 1 
  x = x - 1
  puts "while loop"
end


#for loop
for a in 1..5 do
  puts "for loop"
end
# it takes a range or an array


#loop
x = 1
loop do
  puts "loop do"; x += 1;
  break if x == 5
end

#until
x = 1
until x >= 5 do
  x += 1; puts "until do"
end


# BUT, all of the above is mostly sytactic sugar. Almost all looping can be achieved through use of each, each.with_index, each_index or maybe map
# using each but not passing a block to these methods gives back an enumerator class instead. 
# enumerator has a bunch of methods too but we rarely use them. with_index is likely used
a = (11..20).to_a

a.each do |i|
  puts i
end

a.each.with_index do |i, idx|
  puts "#{i} at position #{idx}"
end

a.each_index do |idx|
  puts idx
end

puts (a.map do |i|
  i *100
end)
