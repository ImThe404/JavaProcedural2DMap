# A java procedural 2D map using perlin noise

![](/gifMap.gif)

The objective of the project is to have a easy to use procedural map in java using a Perlin noise map. 
The map can be easily modify using the variables and the differant color in the color map can be change using buttons.
To see more information on how change settings see the rubric down below.

### 2 Buttons :

#### Noise map 

Use to switch to the noise map, where you can see the variance of gray get from the Perlin noise algorithm.

#### Color map

Use to switch to the color map, where the color pixels are place in function of the float from the noise map.

### Differant settings explain :

`seed`

This variable represents the seed of the map and can be used to made a large number of differant map.

`scale`

This variable represents how much you going to "zoom" in the map. the map is recalculated in every scale and does
not just increase pixel size.

`octaves`

This variable represents how much you going to apply the algorithm. It can be feeling as how much detail you put.
The first octave adds the form, then the second add the path ect...

`persistence`

This variable represents the power with which the ground is going to be smooth.

`lacunarity`

This variable represents the power to which the shapes is going to be round.

`offsetX`

This variable represents the shifts to east and west, on the x axis.

`offsetY`

This variable represents the shifts to north and south, on the y axis.

### How to change color and height ?

To change the number of colors, the color and the percentage of color you want to see, follow the step down below :

#### Change the number of colors

This parameter is more difficult to change and need to be change in the code, just remove the TerrainType you 
don't want in the file `MainFrame`.

#### Change the color

You can change the color by simply click on the buttons affect by the color and a new frame is going to open.
by then just click the color you want and press ok, or if you don't find what you want, press cancel.

#### Change the height/name

You can change the percentage of how much you see each color by changing the height. The color will be paint
of every pixel that have a value between the previous color and the height. 
