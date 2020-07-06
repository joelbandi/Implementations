class Node
  attr_accessor :value, :right, :left
  def initialize(value)
    @value = value
    @left = left
    @right = right
  end
end

def minimal_tree(array)
  create_tree array,0,array.size-1
end


def create_tree(array,left,right)
  return nil if left > right
  m_index = (left+right)/2
  root = Node.new array[m_index]
  root.left = create_tree array,left,m_index-1
  root.right = create_tree array,m_index+1,right
  root
end

t = minimal_tree [1,2,3,4,5,6,7,8,9]
puts t.inspect

=begin 

          5
      2       7
    1   3   6   8
          4       9


=end