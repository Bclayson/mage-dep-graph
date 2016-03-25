(ns mage-dependency-graph.core
  (require [com.stuartsierra.dependency :as dep])
  (:gen-class))

; spell difficulty levels
(def spell-difficulty {:hard "Hard" :very-hard "Very Hard"})

; magery requirements
(def magery-level {:one "Magery Level One" :two "Magery Level Two" :three "Magery Level Three"})

(def mage-colleges
  {:ai "Air" :an "Animal" :b "Body" :c "Communication & Empathy" :ea "Earth" :en "Enchantment" :fi "Fire" :fo "Food"
   :g  "Gate" :h "Healing" :i "Illusion & Creation" :k "Knowledge" :l "Light" :ma "Making & Breaking" :me "Meta"
   :mi "Mind Control" :mo "Movement" :n "Necromantic" :pl "Plant" :pr "Protection" :s "Sound" :t "Technological"
   :wa "Water" :we "Weather"})

(defn get-vals [m]
  (map #(% m) (keys m)))

; Creating spell
(defrecord Spell
  [name college mage-level difficulty])

(defrecord Nonspell
  [name])



(def light-darkness (-> (dep/graph)
                        (dep/depend :b :a)
                        (dep/depend :b :a)
                        (dep/depend :b :a)
                        (dep/depend :b :a)))
