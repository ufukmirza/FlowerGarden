package com.example.flowergarden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.flowercard.view.*


class MainActivity : AppCompatActivity() {

    var flowerList=ArrayList<flower>()
    var adapter:flowerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flowerList.add(flower("Rose","A rose is a woody perennial flowering plant of the genus Rosa, in the family Rosaceae, or the flower it bears.[1] There are over three hundred species and tens of thousands of cultivars.[1] They form a group of plants that can be erect shrubs, climbing, or trailing, with stems that are often armed with sharp prickles.[1] Flowers vary in size and shape and are usually large and showy, in colours ranging from white through yellows and reds.[1] Most species are native to Asia, with smaller numbers native to Europe, North America, and northwestern Africa.[1] Species, cultivars and hybrids are all widely grown for their beauty and often are fragrant. Roses have acquired cultural significance in many societies.[1] Rose plants range in size from compact, miniature roses, to climbers that can reach seven meters in height.[1] Different species hybridize easily, and this has been used in the development of the wide range of garden roses",R.drawable.gul))
        flowerList.add(flower("Chrysanthemum","Chrysanthemums (/krɪˈsænθəməm/), sometimes called mums or chrysanths,[4] are flowering plants of the genus Chrysanthemum in the family Asteraceae. They are native to East Asia and northeastern Europe. Most species originate from East Asia and the center of diversity is in China.[5] Countless horticultural varieties and cultivars exist.",R.drawable.kasimpati))
        flowerList.add(flower("Tulip","Tulips (Tulipa) form a genus of spring-blooming perennial herbaceous bulbiferous geophytes (having bulbs as storage organs). The flowers are usually large, showy and brightly colored, generally red, pink, yellow, or white (usually in warm colors). They often have a different colored blotch at the base of the tepals (petals and sepals, collectively), internally. Because of a degree of variability within the populations, and a long history of cultivation, classification has been complex and controversial. The tulip is a member of the lily family, Liliaceae, along with 14 other genera, where it is most closely related to Amana, Erythronium and Gagea in the tribe Lilieae. There are about 75 species, and these are divided among four subgenera. The name \"tulip\" is thought to be derived from a Persian word for turban, which it may have been thought to resemble. Tulips originally were found in a band stretching from Southern Europe to Central Asia, but since the seventeenth century have become widely naturalised and cultivated (see map). In their natural state they are adapted to steppes and mountainous areas with temperate climates. Flowering in the spring, they become dormant in the summer once the flowers and leaves die back, emerging above ground as a shoot from the underground bulb in early spring.\n" +
                "\n" +
                "Originally growing wild in the valleys of the Tian Shan Mountains, tulips were cultivated in Constantinople as early as 1055. By the 15th century, tulips were among the most prized flowers; becoming the symbol of the Ottomans.[2] While tulips had probably been cultivated in Persia from the tenth century, they did not come to the attention of the West until the sixteenth century, when Western diplomats to the Ottoman court observed and reported on them. They were rapidly introduced into Europe and became a frenzied commodity during Tulip mania. Tulips were frequently depicted in Dutch Golden Age paintings, and have become associated with the Netherlands, the major producer for world markets, ever since. In the seventeenth century Netherlands, during the time of the Tulip mania, an infection of tulip bulbs by the tulip breaking virus created variegated patterns in the tulip flowers that were much admired and valued. While truly broken tulips do not exist anymore, the closest available specimens today are part of the group known as the Rembrandts – so named because Rembrandt painted some of the most admired breaks of his time.[3]\n" +
                "\n" +
                "Breeding programs have produced thousands of hybrid and cultivars in addition to the original species (known in horticulture as botanical tulips). They are popular throughout the world, both as ornamental garden plants and as cut flowers.",R.drawable.lale))

        adapter= flowerAdapter(this,flowerList)
        listView.adapter=adapter
    }

    class flowerAdapter: BaseAdapter {
        var constList=ArrayList<flower>()
        var context: Context?=null

        constructor(context: Context, constList:ArrayList<flower>):super(){
            this.constList=constList
            this.context=context
        }
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posCicekler=constList[position]
            var inflator=context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var cicekKarti=inflator.inflate(R.layout.flowercard,null)
            cicekKarti.flowerName.text = posCicekler.name
            cicekKarti.flowerDescription.text = posCicekler.description
            cicekKarti.flowerPhoto.setImageResource(posCicekler.photo!!)

            cicekKarti.setOnClickListener {

                var intent = Intent(context,flowerdetail::class.java)
                intent.putExtra("flowername", posCicekler.name)
                intent.putExtra("flowerdescription", posCicekler.description)
                intent.putExtra("flowerphoto", posCicekler.photo!!)
                context!!.startActivity(intent)


            }
            return cicekKarti
        }

        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return constList.size
        }

    }


}

