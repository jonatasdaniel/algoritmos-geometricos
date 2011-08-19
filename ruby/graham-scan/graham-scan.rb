class Point
	attr_accessor :x, :y

	def initialize(x, y)
		@x, @y = x, y
	end
	
	def to_s
	  "x:#{x} , y:#{y} - "
	end
end

class GrahamScan
  attr_reader :points
  
  def initialize(points)
    @points = points
  end
  
  def start
    @points.sort! {|a, b| a.x <=> b.x}
    
    superiores = [@points.last, @points.reverse[1]]
    
		for i in 3..@points.size do
      superiores << @points[i]
      
      while superiores.size > 2 and direction(superiores.last, superiores.reverse[1], superiores.reverse[2]) >= 0
        superiores.delete_at(superiores.size-2)
      end
    end
    
    inferiores = [@points.last, @points.reverse[1]]

		for i in @points.size-1..0 do
			inferiores << @points[i]

			while inferiores.size > 2 and direction(inferiores.last, inferiores.reverse[1], inferiores.reverse[2]) >= 0
        inferiores.delete_at(inferiores.size-2)
      end	
		end

		superiores.delete_at 0
		superiores.delete_at superiores.size-1

    new_points = [superiores, inferiores]
    new_points
  end
  
  def direction(p1, p2, p3)
    (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x)
  end
  
  def to_s
    @points.each do |o|
      returned << o.to_s
    end
    returned
  end
end

points = [Point.new(4, 5), Point.new(3, 5), Point.new(5, 5)]
graham_scan = GrahamScan.new(points)
puts "before #{points}"
points = graham_scan.start
puts "after #{points}"
