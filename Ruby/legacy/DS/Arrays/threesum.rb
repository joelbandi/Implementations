def threesum(a,target)
  return [] if a.length <= 2
  
  a.sort!

  (0..a.length-3).each do |i|
    l = i + 1
    r = a.length-1
    while l < r do
      sum = a[i]+a[l]+a[r]
      if sum == target
        return [i,l,r]
      elsif sum < target
        l = l+1
      else
        r = r+1
      end
    end
  end
  []
end

puts threesum [20,7],29

  